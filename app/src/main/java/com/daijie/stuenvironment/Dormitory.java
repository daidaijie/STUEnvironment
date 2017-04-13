package com.daijie.stuenvironment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liyujie on 2017/4/13.
 */

public class Dormitory implements Serializable{

    private String name;

    private List<EnvironmentInfo> environmentInfos;

    private Map<String, EnvironmentInfo> stringEnvironmentInfoMap;

    public Dormitory(String name) {
        this.name = name;
        environmentInfos = new ArrayList<>();
        environmentInfos.add(new EnvironmentInfo("甲醛浓度", "mg/m³", R.drawable.ic_jiaquan));
        environmentInfos.add(new EnvironmentInfo("PM 2.5", "ug/m³", R.drawable.ic_pm25));
        environmentInfos.add(new EnvironmentInfo("湿度", "% RH", R.drawable.ic_shidu));
        environmentInfos.add(new EnvironmentInfo("Co", "mg/m³", R.drawable.ic_co));
        environmentInfos.add(new EnvironmentInfo("So2", "mg/m³", R.drawable.ic_so2));
        environmentInfos.add(new EnvironmentInfo("No2", "mg/m³", R.drawable.ic_no2));

        stringEnvironmentInfoMap = new HashMap<>();
        for (EnvironmentInfo environmentInfo : environmentInfos) {
            stringEnvironmentInfoMap.put(environmentInfo.getName(), environmentInfo);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EnvironmentInfo> getEnvironmentInfos() {
        return environmentInfos;
    }

    public void setEnvironmentInfos(List<EnvironmentInfo> environmentInfos) {
        this.environmentInfos = environmentInfos;
    }

    public EnvironmentInfo getEnvironmentInfo(String infoName) {
        return stringEnvironmentInfoMap.get(infoName);
    }

    public static List<Dormitory> getDormitories() {
        return DormitoriesHolder.sDormitories;
    }

    private static class DormitoriesHolder {
        private static List<Dormitory> sDormitories;

        static {
            sDormitories = new ArrayList<>();
            sDormitories.add(new Dormitory("A座"));
            sDormitories.add(new Dormitory("B座"));
            sDormitories.add(new Dormitory("C座"));
            sDormitories.add(new Dormitory("D座"));
            sDormitories.add(new Dormitory("E座"));
            sDormitories.add(new Dormitory("F座"));
            sDormitories.add(new Dormitory("G座"));
            sDormitories.add(new Dormitory("至诚"));
            sDormitories.add(new Dormitory("弘毅"));
            sDormitories.add(new Dormitory("思源"));
            sDormitories.add(new Dormitory("知行"));
        }
    }
}
