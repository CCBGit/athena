package com.ccb.testcenter.athena.dataprocess.entity;

import com.ccb.testcenter.athena.dataprocess.mapping.TransitionRule;

/**
 * 
 * @author pandong
 *
 * 映射项
 */
public class Item {

	private Field field;
	private TransitionRule transitionRule;

	public Item(Field field, TransitionRule transitionRule) {
		super();
		this.field = field;
		this.transitionRule = transitionRule;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public TransitionRule getTransitionRule() {
		return transitionRule;
	}

	public void setTransitionRule(TransitionRule transitionRule) {
		this.transitionRule = transitionRule;
	}

}
