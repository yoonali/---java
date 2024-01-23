import java.util.HashMap;
import java.util.Map;

public class q1_a1 {
	//��Ʈ�ڵ� ����  1. two-sum
	//Ǯ�� 2. ù���� ���� �� Ű ��ȸ

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numsMap = new HashMap<>();
		//Ű�� ���� �ٲ㼭 ������ ����
		for (int i = 0; i < nums.length; i++) {
			numsMap.put(nums[i], i);
		}
		
		//target���� ù ��° ���� �� ����� Ű�� ��ȸȭ�� ���� �ε����� �ƴ� ��� �������� ����
		for (int i = 0; i < nums.length; i++) {
			if (numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i]))
				return new int[] {i, numsMap.get(target - nums[i])};
	}
		//�׻� ������ �����ϹǷ� ���� ���ϵǴ� ���� ����
		return null;
		
	}

}
