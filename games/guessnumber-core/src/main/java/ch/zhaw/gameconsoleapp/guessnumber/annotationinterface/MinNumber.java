package ch.zhaw.gameconsoleapp.guessnumber.annotationinterface;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * MinNumber
 *
 * atInterface
 * Defines this class to be an annotation interface.
 * Annotation "ClassName" can be added to fields, parameters and methods.
 *
 * atTarget({array_with_applicable_enum-constants-of-ElementTypes})
 * Indicates the contexts in which an annotation type is applicable.
 *
 * atRetention(RetentionDuration_of_annotation)
 * Indicates how long annotations with the annotated type are to be retained.
 * RetentionPolicy.RUNTIME
 * Annotations are recorded in the class file by the compiler and retained by the Java Virtual Machine at runtime.
 *
 * atQualifier
 * The Spring annotation, used to annotate other custom annotations, that can in turn be used as qualifiers.
 *
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 0.0.1
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface MinNumber {
}
