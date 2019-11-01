package com.example.module.project.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MapAgreement {

    private List<MapBuildCompany> buildCompany = new ArrayList<>();
    private List<MapManageCompany> manageCompany = new ArrayList<>();
    private List<MapDesignCompany> designCompany = new ArrayList<>();
    private List<MapContractCompany> contractCompany = new ArrayList<>();
    private List<MapOtherCompany> otherCompany = new ArrayList<>();
    private List<MapLaborTeamList> laborTeamList = new ArrayList<>();
}
