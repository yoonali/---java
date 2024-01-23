import java.util.HashMap;
import java.util.Map;

public class q1_a2 {

	//리트코드 문제  1. two-sum
	//풀이 3. 조회 구조 개선 - for문을 하나로 축소

		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> numsMap = new HashMap<>();
			//하나의 for 반복으로 통합
			for (int i = 0; i < nums.length; i++) {
				//target에서 num을 뺀 값이 있으면 정답으로 리턴
				if(numsMap.containsKey(target - nums[i])) {
					return new int[] {numsMap.get(target - nums[i]), i};
					//#2와 다르게 (i, target - nums[i])가 아닌 이유
					//차례대로 map에 삽입하며 결과를 찾기 때문에 맵에 들어있는 값이 현재 인덱스보다 항상 더 작으므로 맵에 있는 값을 먼저 리턴해야 작은 값에서 높은 값 순으로 리턴되기 때문
	
			}
			//정답이 아니므로 다음번 비교를 위해 인덱스를 맵에 저장
			numsMap.put(nums[i], i);
			
		}
			//항상 정답이 존재하므로 널이 리턴되는 경우는 없음
			return null;
			
		}
}
