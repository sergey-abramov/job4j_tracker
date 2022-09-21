package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0.0;
        double num = 0.0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                num++;
            }
        }
        return sum / num;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> pupil = new ArrayList<>();
        for (Pupil pupilList : pupils) {
            double sum = 0.0;
            for (Subject subject : pupilList.subjects()) {
                sum += subject.score();
            }
            pupil.add(new Label(pupilList.name(), sum / pupilList.subjects().size()));
        }
        return pupil;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> pupil = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupilList : pupils) {
            for (Subject subject : pupilList.subjects()) {
                if (map.containsKey(subject.name())) {
                    map.put(subject.name(), subject.score() + map.get(subject.name()));
                } else {
                    map.put(subject.name(), subject.score());
                }
            }
        }
        for (String subject : map.keySet()) {
            pupil.add(new Label(subject, (double) map.get(subject) / pupils.size()));
        }
        return pupil;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> pupil = new ArrayList<>();
        for (Pupil pupilList : pupils) {
            double sum = 0.0;
            for (Subject subject : pupilList.subjects()) {
                sum += subject.score();
            }
            pupil.add(new Label(pupilList.name(), sum));
        }
        pupil.sort(Comparator.naturalOrder());
        return pupil.get(pupil.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> sub = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupilList : pupils) {
            for (Subject subject : pupilList.subjects()) {
                if (map.containsKey(subject.name())) {
                    map.put(subject.name(), subject.score() + map.get(subject.name()));
                } else {
                    map.put(subject.name(), subject.score());
                }
            }
        }
        for (String subject : map.keySet()) {
            sub.add(new Label(subject, map.get(subject)));
        }
        sub.sort(Comparator.naturalOrder());
        return sub.get(sub.size() - 1);
    }
}
