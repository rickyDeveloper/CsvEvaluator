package com.naiyar.processor;

/**
 * Created by vikasnaiyar on 17/10/16.
 *
 * Implementing stragety pattern here
 * so that we can add new processros as an when required.
 *
 */
public interface InputProcessor {
    String process(String data);
}
