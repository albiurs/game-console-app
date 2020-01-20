/**
 * module-info
 * ch.zhaw.gameconsoleapp
 *
 * @author created by Slavisa Obradovic, on 2019-01-01
 * @version 1.0
 */
module gameoflife.core {
    requires javafx.controls;
    requires spring.beans;
    requires spring.context;

    exports ch.zhaw.gameconsoleapp.gameoflife.core.service;
}