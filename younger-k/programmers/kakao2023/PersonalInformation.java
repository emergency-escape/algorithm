package programmers.kakao2023;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PersonalInformation {
  public int[] solution(String today, String[] terms, String[] privacies) {
    List<Integer> answers = new ArrayList<>();
    Map<String, Integer> mTerm = new HashMap<>();
    for(String term : terms) {
      String[] aTerm = term.split(" ");
      mTerm.put(aTerm[0], Integer.parseInt(aTerm[1]));
    }

    LocalDate dToday = toLocalDate(today);
    for (int i = 0; i < privacies.length; i++) {
      String[] arrPrivacy = privacies[i].split(" ");
      LocalDate agreeDate = toLocalDate(arrPrivacy[0]);
      String termType = arrPrivacy[1];
      int month = mTerm.get(termType);

      LocalDate destroyDate = agreeDate.plusMonths(month);
      if (!isAvailable(dToday, destroyDate)) {
        answers.add(i + 1);
      };
    }

    return answers.stream().mapToInt(Integer::intValue).toArray();
  }

  public boolean isAvailable(LocalDate today, LocalDate until) {
    return today.isBefore(until);
  }

  public LocalDate toLocalDate(String strDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    return LocalDate.parse(strDate, formatter);
  }
}