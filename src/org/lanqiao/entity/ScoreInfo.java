package org.lanqiao.entity;

public class ScoreInfo {
	
	private int score_id;
	private float score_value;
	
	public ScoreInfo(){}
	public ScoreInfo(int score_id, float score_value) {
		super();
		this.score_id = score_id;
		this.score_value = score_value;
	}
	public int getScore_id() {
		return score_id;
	}
	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}
	public float getScore_value() {
		return score_value;
	}
	public void setScore_value(float score_value) {
		this.score_value = score_value;
	}
	
	
	
}
