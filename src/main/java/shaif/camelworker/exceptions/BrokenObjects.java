/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shaif.camelworker.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author if
 */
public interface BrokenObjects {
    List<BrokenObject> brokenObjects=new ArrayList<>();
    default List<BrokenObject> getBrokenObjects(){
        return brokenObjects;
    }
}
