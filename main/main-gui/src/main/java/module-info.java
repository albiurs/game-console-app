/**
 * module-info
 * ch.zhaw.gameconsoleapp
 *
 * @author created by Urs Albisser, on 2019-12-04
 * @version 1.0
 */
module ch.zhaw.gameconsoleapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.core;
    requires spring.context;

    requires gameoflife.core;
    //requires gameoflife.gui;

    opens ch.zhaw.gameconsoleapp to spring.core, javafx.fxml;
    exports ch.zhaw.gameconsoleapp;
}