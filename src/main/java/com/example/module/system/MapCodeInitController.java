package com.example.module.system;

import com.example.module.system.model.MapCode;
import com.example.module.system.model.MapCodeCategory;
import com.example.module.system.model.MapcodeParam;
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "数据字典初始化")
@RequestMapping("/init/datas")
public class MapCodeInitController {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private SystemService systemService;

    @ApiOperation("字典数据分类")
    @GetMapping("/dict/category")
    public Result<MapCodeCategory> initMapCodeCategory(@ApiParam(value = "标签",required = true ,defaultValue = "") String label,
                                                       @ApiParam(value = "分类",required = true ,defaultValue = "")String categoryName,
                                                       @ApiParam(value = "父节点ID",required = true ,defaultValue = "0")String parentId){
        return Result.success(systemService.insertCategory(label, categoryName, parentId));
    }


    @ApiOperation(value = "字典数据项目",consumes="application/json", produces="application/json")
    @ApiImplicitParam(name = "param", value = "字典数据项PO对象", required = true, dataType = "MapcodeParam")
    @PostMapping(value = "/dict/mapcode", consumes="application/json", produces="application/json")
    public Result<List<MapCode>> initMapCodeItem(@RequestBody MapcodeParam param){
        return Result.success(systemService.insertCategoryItems(param));
    }



    //合同类型
    @ApiOperation("合同类型字典数据")
    @GetMapping("/dict/contracttype")
    public Result<List<MapCode>> initContractType(){
        final String CATEGORYID = "0dd1416f17364eafbaf42758b9fzxcvb";
        final String LABEL = "project_contract_type";
        List<MapCode> retruns = (List<MapCode>)mongoTemplate.insert(buildMaoCodes(LABEL,CATEGORYID,
                "销售+安装通发票10%","销售","改造","设计"),"sys_dict");
        return Result.success(retruns);
    }

    //合同类型
    @ApiOperation("合同-合伙人-合同类型")
    @GetMapping("/dict/partnerContractType")
    public Result<List<MapCode>> initPartnerContractType(){
        final String CATEGORYID = "0dd1416f17364eafbaf42758b9fzxcv0";
        final String LABEL = "partner_contract_type";
        List<MapCode> retruns = (List<MapCode>) mongoTemplate.insert(buildMaoCodes(LABEL,CATEGORYID,
                "城市合伙人合同","项目合伙人合同"),
                "sys_dict");
        return Result.success(retruns);
    }

    //开票类型
    @ApiOperation("开票类型字典数据")
    @GetMapping("/dict/invoicetype")
    public Result<List<MapCode>> initInvoiceType(){
        final String CATEGORYID = "1231416f17qweraasdf42758b9fzxcvb";
        final String LABEL = "invoice_type";
        List<MapCode> retruns = (List<MapCode>)mongoTemplate.insert(buildMaoCodes(LABEL,CATEGORYID,
                "增值税普通发票10%","增值税普通发票16%","增值税普通发票3%","增值税普通发票6%","增值税专用发票10%",
                "增值税专用发票16%","增值税专用发票3","增值税专用发票6%"),"sys_dict");
        return Result.success(retruns);
    }


    //结算方式
    @ApiOperation(value = "财务-账户资金类型")
    @GetMapping("/dict/accountmoneytype")
    public Result<List<MapCode>> initAccountMoneyType(){
        final String CATEGORYID = "ce38761594744cc994e757hjkgrgghht";
        final String LABEL = "account_money_type";
        List<MapCode> retruns = (List<MapCode>)mongoTemplate.insert(buildMaoCodes(LABEL,CATEGORYID,
                "现金","备用金","基本户","保证金户","一般户","银行承兑汇票(三方)","银行承兑汇票(两方)","商业承兑汇票"),"sys_dict");
        return Result.success(retruns);
    }


    //结算方式
    @ApiOperation(value = "财务-银行账户类型")
    @GetMapping("/dict/bankaccounttype")
    public Result<List<MapCode>> initBankAccountType(){
        final String CATEGORYID = "ce387615947888964e75b57e6e6a2a6";
        final String LABEL = "bank_account_type";
        List<MapCode> retruns = (List<MapCode>)mongoTemplate.insert(buildMaoCodes(LABEL,CATEGORYID,"现金帐户","银行帐户"),"sys_dict");
        return Result.success(retruns);
    }

    //结算方式
    @ApiOperation(value = "财务-结算方式")
    @GetMapping("/dict/settlementway")
    public Result<List<MapCode>> initSettlementWay(){
        final String CATEGORYID = "6e25c1a6c4c94439a20e041c2b9e5998";
        final String LABEL = "settlement_way";
        List<MapCode> retruns = (List<MapCode>)mongoTemplate.insert(buildMaoCodes(LABEL,CATEGORYID,"保函","现金","转账","转账/现金支票","冲账","商业承兑汇票","银行承兑汇票"),"sys_dict");
        return Result.success(retruns);
    }

    @ApiOperation("财务-费用类别")
    @GetMapping("/dict/costtype")
    public Result<List<MapCode>> initCostType(){
        final String CATEGORYID = "e9dd77288c2c45f3b4bb02e56b2f55a2";
        final String LABEL = "cost_type";
        List<MapCode> retruns = (List<MapCode>) mongoTemplate.insert(buildMaoCodes(LABEL,CATEGORYID,
                "招商大会","管理人员房租", "软件费用", "招待客户","其他","保险费","团队活动费","员工出差住宿费",
                "汽车加油费用","打印机租赁费","礼品","办公场地租赁费","员工招聘费用","办公用品购买","市内公办车费","广告费","维修费","中介费",
                "会议费、协会费","工程费用","员工车补","员工通讯费","员工出差补贴","团队活动","招待费", "培训费", "律师费",
                "办公场地水电","财务年报审计费","金融机构贷款费用","加班车补", "项目中标标书制作", "加班餐补",
                "快递费", "资质类", "员工出差交通费","员工生日福利", "办公场地物业费"),
                "sys_dict");
        return Result.success(retruns);
    }

    @ApiOperation("财务-付款-经营类-款项类型")
    @GetMapping("/dict/managepaymenttype")
    public Result<List<MapCode>> initManagePaymentType(){
        final String CATEGORYID = "ce38761594744cc994e75b57e6546548";
        final String LABEL = "manage_payment_type";
        List<MapCode> retruns = (List<MapCode>) mongoTemplate.insert(buildMaoCodes(LABEL,CATEGORYID,
                "招商大会","支付采购款-预付款", "支付采购款-到货款","支付采购款-质保款",
                "支付劳务款-工程款","支付采购款-投资款","支付劳务款-投资款","支付投标保证金","支付履约保证金",
                "支付安全施工保证金","支付职工福利费","支付税款",
                "支付投资款","支付报销款-投资款",
                "支付员工报销款","支付其他经营活动款"),
                "sys_dict");
        return Result.success(retruns);
    }

    @ApiOperation("财务-付款-投资类-款项类型")
    @GetMapping("/dict/investPaymentType")
    public Result<List<MapCode>> initInvestPaymentType() {
        final String CATEGORYID = "ce38761566784cc994e75b57e6e6a2a6";
        final String LABEL = "invest_payment_type";
        List<MapCode> retruns = (List<MapCode>) mongoTemplate.insert(buildMaoCodes(LABEL, CATEGORYID,
                "支付资产购置款","支付对外投资款","支付其他投资活动款","支付子（分）公司款"),
                "sys_dict");
        return Result.success(retruns);
    }

    @ApiOperation("财务-付款-筹资类-款项类型")
    @GetMapping("/dict/financingPaymentType")
    public Result<List<MapCode>> initFinancingPaymentType() {
        final String CATEGORYID = "ce38761594744cc994e776767676a2a6";
        final String LABEL = "financing_payment_type";
        List<MapCode> retruns = (List<MapCode>) mongoTemplate.insert(buildMaoCodes(LABEL, CATEGORYID,
                "支付债务款", "支付股息红利款","支付其他筹资活动款"),
                "sys_dict");
        return Result.success(retruns);
    }

    @ApiOperation("财务-付款-资金转换类-款项类型")
    @GetMapping("/dict/transPaymentType")
    public Result<List<MapCode>> initTransPaymentType() {
        final String CATEGORYID = "a8391ceb46bc846d0614d69798ddded6";
        final String LABEL = "trans_payment_type";
        List<MapCode> retruns = (List<MapCode>) mongoTemplate.insert(
                buildMaoCodes(LABEL, CATEGORYID,
                        "总部资金转换", "合伙人资金调拨", "合伙人借款", "支付年费", "支付管理费", "支付税费"),
                        "sys_dict");
        return Result.success(retruns);
    }


   // ---------------------------------------------------

    @ApiOperation("财务-收款-经营类-款项类型")
    @GetMapping("/dict/managepaymentInType")
    public Result<List<MapCode>> initManagePaymentInType(){
        final String CATEGORYID = "e5ede8766f7027d4dd854d6e00b09d4e";
        final String LABEL = "manage_payment_in_type";
        List<MapCode> retruns = (List<MapCode>) mongoTemplate.insert(buildMaoCodes(LABEL,CATEGORYID,
                "收工程回款", "收年费", "收管理费", "项目增收款", "金融赋能增收款", "政府补贴及税收返还款",
                "收投资款", "收税费", "借款（外部汇入）", "收投标保证金", "收履约保证金", "收其他经营活动款"),
                "sys_dict");
        return Result.success(retruns);
    }

    @ApiOperation("财务-收款-投资类-款项类型")
    @GetMapping("/dict/investPaymentInType")
    public Result<List<MapCode>> initInvestPaymentInType() {
        final String CATEGORYID = "77b9f7fb46b9698c08b3413208c4c524";
        final String LABEL = "invest_payment_in_type";
        List<MapCode> retruns = (List<MapCode>) mongoTemplate.insert(buildMaoCodes(LABEL, CATEGORYID,
                "收公司对外投资款","投资收益","资产处置款","处置子（分）公司款","收其他投资活动款"),
                "sys_dict");
        return Result.success(retruns);
    }

    @ApiOperation("财务-收款-筹资类-款项类型")
    @GetMapping("/dict/financingPaymentInType")
    public Result<List<MapCode>> initFinancingPaymentInType() {
        final String CATEGORYID = "5bcf97d3fb41108eb98a8b0f01a29f47";
        final String LABEL = "financing_payment_in_type";
        List<MapCode> retruns = (List<MapCode>) mongoTemplate.insert(buildMaoCodes(LABEL, CATEGORYID,
                "吸收投资款", "金融机构贷款","发行债券款","其他筹资活动款"),
                "sys_dict");
        return Result.success(retruns);
    }

    @ApiOperation("财务-收款-资金转换类-款项类型")
    @GetMapping("/dict/transPaymentInType")
    public Result<List<MapCode>> initTransPaymentInType() {
        final String CATEGORYID = "b579e8eba4893ab7eb813b660f87da1d";
        final String LABEL = "trans_payment_in_type";
        List<MapCode> retruns = (List<MapCode>) mongoTemplate.insert(
                buildMaoCodes(LABEL, CATEGORYID,
                        "总部资金转换", "合伙人资金调拨", "合伙人借款（内部转入）", "扣年费", "扣管理费", "扣税费"),
                "sys_dict");
        return Result.success(retruns);
    }

    @ApiOperation("财务-调整对象")
    @GetMapping("/dict/changeObjectType")
    public Result<List<MapCode>> initChangeObjectType() {
        final String CATEGORYID = "6e25c4t6c2c94439a20e041c2b9e5998";
        final String LABEL = "调整对象";
        List<MapCode> retruns = (List<MapCode>) mongoTemplate.insert(
                buildMaoCodes(LABEL, CATEGORYID,
                        "累计开票金额(开给业主方的发票金额)", "累计收票金额(收到合伙人的发票金额)", "项目投资金额(收到合伙人投资款)", "项目回款金额(收到业主方款项)", "项目支付金额(支付给合伙人)",
                        "项目扣款金额(管理费)", "项目扣款金额(税费)", "项目扣款金额(其他)", "项目罚款金额", "销项票税额(开给业主方的发票的税额)", "进项票税额(收到合伙人的发票的税额)", "外经证税额",
                        "公司借入", "往来调拨收款", "往来调拨付款", "代采购付款", "项目扣款金额(年费)", "收保证金", "付保证金", "其他回款", "其他付款", "公司借支"),
                "sys_dict");
        return Result.success(retruns);
    }




    private List<MapCode> buildMaoCodes(String label, String category,String ... dictNames){
        return Arrays.asList(dictNames).stream()
                .map(s -> MapCode.getInstace(s, label, category))
                .collect(Collectors.toList());
    }


//----------------------组织机构---------------------------------


}


