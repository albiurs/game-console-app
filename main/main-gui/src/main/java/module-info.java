
/**
 * module-info
 * ch.zhaw.gameconsoleapp
 *
 * @author created by Urs Albisser, on 2019-12-04
 * @version 0.0.1
 */
module ch.zhaw.gameconsoleapp {

    requires spring.core;
    requires spring.beans;
    requires spring.context;
    
    requires spring.boot;
    requires spring.boot.autoconfigure;
    
    requires javafx.fxml;
    requires javafx.controls;
    
    
    opens ch.zhaw.gameconsoleapp to spring.core, javafx.fxml;
    exports ch.zhaw.gameconsoleapp;
}