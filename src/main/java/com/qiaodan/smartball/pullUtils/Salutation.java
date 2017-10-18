package com.qiaodan.smartball.pullUtils;

import java.util.ArrayList;
import java.util.List;

public class Salutation {
	public static void main(String[] args) {
		int weight = 60;
		double height = 161; int age = 38; int perf = 45; int run = 61; int break_rank = 45; int bounce = 30;
		int handle = 1; int active = 56;
		try {
			getSalutation(weight, height, age, perf, run, break_rank, bounce, handle, active);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * weight 体重，  height 身高（单位cm）， age 年龄, perf 综合（0-100）, run 跑动 （0-100）, break_rank 突破（0-100）,
	 *  bounce 弹跳（0-100）, handle 手感（1到5）, active 活跃占比 0-100
	 */
	public static String getSalutation(int weight, double height, int age, int perf, int run, int break_rank, int bounce,
			int handle, int active) throws Exception {
		String salu = String.valueOf(15);
		List<String> salus = new ArrayList<String>();
		if (weight == 0) {
			throw new Exception("体重为空！");
		}
		if (height == 0) {
			throw new Exception("身高为空！");
		}
		if (age == 0) {
			throw new Exception("年龄为空！");
		}
		
		double bmi = weight / Math.pow(height/100, 2);
		// 1.灵活死胖子
		if (bmi >= 26.5 && (handle >= 4 || perf >= 40)) {
			salus.add(String.valueOf(1));
		}
		// 2 矮壮
		if (24 <= bmi && bmi <= 26.5 && height <= 165 && (bounce >= 40 || perf >= 40)) {
			salus.add(String.valueOf(2));
		}
		// 3.
		if (age >= 30 && (handle >= 4 || perf >= 40)) {
			salus.add(String.valueOf(3));
		}
		// 4.
		if (height >= 180 && bmi <= 21 && (handle >= 4 || perf >= 40)) {
			salus.add(String.valueOf(4));
		}
		// 5.
		if (handle == 5) {
			salus.add(String.valueOf(5));
		}
		// 6.
		if (active <= 30 && (perf <= 30 || handle <= 2)) {
			int index=(int)(Math.random()*2);
			salus.add("6."+(index+1));
		}
		// 7.
		if (active > 30 && perf <= 30 || break_rank >= 30 && handle <= 2) {
			int index=(int)(Math.random()*2);
			salus.add("7."+(index+1));
		}
		// 8.
		if ((active <= 30 || perf <= 30) && handle >= 4) {
			int index=(int)(Math.random()*2);
			salus.add("8."+(index+1));
		}
		// 9.
		if (active > 30 && break_rank >= 40) {
			salus.add(String.valueOf(9));
		}
		// 10.
		if (height >= 175 && perf >= 40 && handle == 5) {
			salus.add(String.valueOf(10));
		}
		// 11.
		if (break_rank <= 30 && handle >= 4) {
			int index=(int)(Math.random()*2);
			salus.add("11."+(index+1));
		}
		// 12.
		if (handle == 1) {
			salus.add(String.valueOf(12));
		}
		// 13.
		if (run <= 30 && active <= 30) {
			int index=(int)(Math.random()*3);
			salus.add("13."+(index+1));
		}
		// 14.
		if (handle <= 3 && (perf <= 50 || active <= 50)) {
			salus.add(String.valueOf(14));
		}
		// 15.
		if (perf > 30) {
			salus.add(String.valueOf(15));
		}
		// 16.
		if (perf <= 25 && handle == 1) {
			salus.add(String.valueOf(16));
		}
		//
		if(salus.size() > 0){
			//产生0-(arr.length-1)的整数值,也是数组的索引
			int index=(int)(Math.random()*salus.size());
			salu = salus.get(index);
		}
		return salu;
	}
}
