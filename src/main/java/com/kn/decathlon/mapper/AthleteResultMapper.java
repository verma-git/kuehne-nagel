package com.kn.decathlon.mapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kn.decathlon.entity.Athlete;
import com.kn.decathlon.entity.Result;

public class AthleteResultMapper {

	public static List<Result> map(List<Athlete> athletes) {
		athletes.sort(Comparator.comparing(Athlete::getTotalPoints).reversed());
		List<Result> results = new ArrayList<>();
		athletes.stream().forEach(a -> {
			Result finalResult = converter(a);
			results.add(finalResult);
		});
		return createRank(results);
	}

	private static Result converter(Athlete athlete) {
		Result result = new Result();
		result.setAthleteName(athlete.getName());
		result.setTotalPoints((int) athlete.getTotalPoints());
		return result;
	}

	private static List<Result> createRank(List<Result> rList) {
		Set<Integer> check = new HashSet<>();
		for (int i = 0; i < rList.size(); i++) {
			if (check.contains(rList.get(i).getTotalPoints())) {
				String r15 = rList.get(i - 1).getRank();
				String[] split = r15.split("-");
				for (int j = split.length; j > 0; j--) {
					Result s1 = rList.get(i - j);
					s1.setRank(s1.getRank() + "-" + (i + 1));
				}
				rList.get(i).setRank(rList.get(i - 1).getRank());
			} else {
				check.add(rList.get(i).getTotalPoints());
				rList.get(i).setRank(i + 1 + "");
			}
		}
		return rList;
	}

}
