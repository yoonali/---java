import java.util.HashMap;
import java.util.Map;

public class q1_a2 {

	//��Ʈ�ڵ� ����  1. two-sum
	//Ǯ�� 3. ��ȸ ���� ���� - for���� �ϳ��� ���

		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> numsMap = new HashMap<>();
			//�ϳ��� for �ݺ����� ����
			for (int i = 0; i < nums.length; i++) {
				//target���� num�� �� ���� ������ �������� ����
				if(numsMap.containsKey(target - nums[i])) {
					return new int[] {numsMap.get(target - nums[i]), i};
					//#2�� �ٸ��� (i, target - nums[i])�� �ƴ� ����
					//���ʴ�� map�� �����ϸ� ����� ã�� ������ �ʿ� ����ִ� ���� ���� �ε������� �׻� �� �����Ƿ� �ʿ� �ִ� ���� ���� �����ؾ� ���� ������ ���� �� ������ ���ϵǱ� ����
	
			}
			//������ �ƴϹǷ� ������ �񱳸� ���� �ε����� �ʿ� ����
			numsMap.put(nums[i], i);
			
		}
			//�׻� ������ �����ϹǷ� ���� ���ϵǴ� ���� ����
			return null;
			
		}
}
