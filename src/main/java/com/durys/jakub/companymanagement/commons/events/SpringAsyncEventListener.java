package com.durys.jakub.companymanagement.commons.events;

import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
@Async
public @interface SpringAsyncEventListener {
}
