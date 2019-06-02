package com.merenaas.util.validAnnotation;

import java.lang.annotation.Annotation;

public class FieldMatch implements Annotation {
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
