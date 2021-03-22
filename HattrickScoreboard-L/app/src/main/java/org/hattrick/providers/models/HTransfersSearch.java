package org.hattrick.providers.models;

import java.util.ArrayList;

/**
 *
 */
public class HTransfersSearch {


    int ageMin;
    int ageDaysMin = 0;
    int ageMax;
    int ageDaysMax = 111;
    int pageSize = 25;
    int pageIndex = 0;
    int specialty;
    int nativeCountryId;
    int tsiMin;
    int tsiMax;
    int priceMin;
    int priceMax;

    ArrayList<HTransfersSkill> Skills = new ArrayList<HTransfersSkill>();

    public String getURL(){

//        return "&ageMin=20&ageMax=22&skillType1=8&minSkillValue1=7&maxSkillValue1=9";
        String url = "&ageMin="+ageMin
                +"&ageDaysMin="+ageDaysMin
                +"&ageMax="+ageMax
                +"&ageDaysMax="+ageDaysMax;

        //Skills
        for(int i=0; i < Skills.size(); i++){
            HTransfersSkill skill = Skills.get(i);
            url+="&skillType"+(i+1)+"="+skill.getSkillType()
                    +"&minSkillValue"+(i+1)+"="+skill.getMinSkillValue()
                    +"&maxSkillValue"+(i+1)+"="+skill.getMaxSkillValue();
        }

        //Optional
        url += (specialty > 0)? "&speciality="+specialty : "";
        url += (nativeCountryId > 0)? "&nativeCountryId="+nativeCountryId : "";
        url += (tsiMin > 0)? "&tsiMin="+tsiMin : "";
        url += (tsiMax > 0)? "&tsiMax="+tsiMax : "";
        url += (priceMin > 0)? "&priceMin="+priceMin : "";
        url += (priceMax > 0)? "&priceMax="+priceMax : "";

        url += "&pageSize="+pageSize
                        +"&pageIndex="+pageIndex;

        return url;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public void setAgeDaysMin(int ageDaysMin) {
        this.ageDaysMin = ageDaysMin;
    }

    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    public void setAgeDaysMax(int ageDaysMax) {
        this.ageDaysMax = ageDaysMax;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setSpecialty(int specialty) {
        this.specialty = specialty;
    }

    public void setNativeCountryId(int nativeCountryId) {
        this.nativeCountryId = nativeCountryId;
    }

    public void setTsiMin(int tsiMin) {
        this.tsiMin = tsiMin;
    }

    public void setTsiMax(int tsiMax) {
        this.tsiMax = tsiMax;
    }

    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }

    public void addSkill(int skillType, int minSkillValue, int maxSkillValue) {
        Skills.add(new HTransfersSkill(skillType, minSkillValue, maxSkillValue));
    }


    class HTransfersSkill {

        int skillType;
        int minSkillValue;
        int maxSkillValue;

        public HTransfersSkill(int skillType, int minSkillValue, int maxSkillValue) {
            this.skillType = skillType;
            this.minSkillValue = minSkillValue;
            this.maxSkillValue = maxSkillValue;
        }

        public int getSkillType() {
            return skillType;
        }

        public int getMinSkillValue() {
            return minSkillValue;
        }

        public int getMaxSkillValue() {
            return maxSkillValue;
        }
    }
}
