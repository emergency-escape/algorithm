Greedy
==
- `Greedy`는 **탐욕스러운** 이라는 의미
- 각 단계에서 당장 눈 앞에 보이는 최적의 선택을 하여 해답을 찾는 알고리즘
- 최적의 해를 찾는데 사용되는 알고리즘.
- 동적 프로그래밍 사용 시 지나치게 많은 계산을 하는 것에 착안하여 고안된 알고리즘.
- 모든 경우에서 최적의 해를 보장하지는 않으나 최적의 값에 **근사한 값**을 목표로 함

조건
--
다음 두 조건이 만족되어야 적용이 가능하다.

1. 탐욕 선택 속성
   - 앞의 선택이 이후의 선택에 영향을 주지 않는다.
2. 최적 부분 구조
   - 문제에 대한 최종 해결 방법은 부분 문제에 대한 최적 문제 해결 방법으로 구성.

과정
--
1. 선택 절차 : 현재 상태에서 가장 최적의 해답 선택
2. 적절성 검사 : 선택된 해가 문제의 조건을 만족하는지 검사
3. 해답 검사 : 원래의 문제가 해결되었는지 검사하고, 해결되지 않았다면 선택 절차로 돌아가 위 과정 반복

예시
--
### 시간표 짜기 문제

다음 시간표 목록을 이용하여 되도록 많은 과목을 듣는 알찬 시간표를 짜보자.

| 과목명 | 수업 시작   | 수업 종료   |
|-----|---------|---------|
| 국 어 | 9:00AM  | 10:00AM |
| 영어  | 9:30AM  | 10:30AM |
| 수학  | 10:00AM | 11:00AM |
| 사회  | 10:30AM | 11:30AM |
| 과학  | 11:00AM | 12:00AM |

1. 최대한 많은 과목을 듣기 위해 가장 빨리 끝나는 과목을 선택하여 첫 번째 과목으로 신청 (국어)
2. 신청한 과목이 끝난 후 시작하는 과목 중 가장 빨리 끝나는 과목 신청 (국어 - 수학)
3. 2번의 과정을 반복 (국어 - 수학 - 과학)