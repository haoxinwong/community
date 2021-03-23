/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WarSpite
 */
public class LolAvailableCategory {
    private List<String>availableGeneralCategorys = new ArrayList<>();
    private List<String>availableOfficialCategorys = new ArrayList<>();

    public LolAvailableCategory() {
        setAvailableCategory();
    }
    
    private void setAvailableCategory(){
        availableGeneralCategorys.add("Information");
        availableGeneralCategorys.add("Announcement");
        availableGeneralCategorys.add("Activity");
        availableOfficialCategorys.add("Test Related");
        availableOfficialCategorys.add("Developer");
        availableOfficialCategorys.add("Research");
        
    }


    public List<String> getAvailableGeneralCategorys() {
        return availableGeneralCategorys;
    }

    public void setAvailableGeneralCategorys(List<String> availableGeneralCategorys) {
        this.availableGeneralCategorys = availableGeneralCategorys;
    }

    public List<String> getAvailableOfficialCategorys() {
        return availableOfficialCategorys;
    }

    public void setAvailableOfficialCategorys(List<String> availableOfficialCategorys) {
        this.availableOfficialCategorys = availableOfficialCategorys;
    }
    
    
}
