/**
 * module-info
 * ch.zhaw.gameconsoleapp
 *
 * @author created by Slavisa Obradovic, on 2019-01-01
 * @version 1.0
 */
module start.gui {
    requires javafx.controls;
    requires org.slf4j;
    requires spring.beans;
    requires spring.boot.autoconfigure;
    requires spring.context;

    //requires gameoflife.core;
    requires gameoflife.gui;

    exports ch.zhaw.gameconsoleapp.start;
}