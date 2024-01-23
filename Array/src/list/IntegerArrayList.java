package list;

public class IntegerArrayList implements IntegerListInterface {
	
	private Integer[] item;
	private int numItems;
	//��� ����
	private static final int DEFAULT_CAPACITY = 64;
	
	public IntegerArrayList() {
		//�����ڸ� �Ķ���� ���� ȣ���ϸ� ��� DEFAULT_CAPACITYũ���� �迭�� �Ҵ�
		item = new Integer[DEFAULT_CAPACITY];
		//����Ʈ�� ���ҵ��� �迭 item[]�� �����ϴµ� Ȯ���� �迭�� �� ����Ʈ�̹Ƿ� ����Ʈ�� �� ���� ���� �����ϴ� ���� numItems�� 0���� �ʱ�ȭ�Ѵ�.
		numItems = 0;
	}
	
	public IntegerArrayList(int n) {
		//�Ķ���Ͱ� �־�����(������ 2�� n) �Ķ���ͷ� ������ ũ���� �迭�� �Ҵ��Ѵ�.
		item = new Integer[n];
		numItems = 0;
	}

	//�迭 ����Ʈ�� k��° �ڸ��� ���� x �����ϱ� 
	@Override
	public void add(int index, Integer x) {
		if(numItems >= item.length || index < 0 || index > numItems) {
			/* ����ó�� */
		} else {
			for (int i = numItems - 1; i>= index; i--) 
				item[i + 1] = item[i]; //�����Ʈ
			item[index] = x;
			numItems++;
		}
		
	}

	//�迭 ����Ʈ�� �� �ڿ� ���� �߰��ϱ� 
	@Override
	public void append(Integer x) {
		if(numItems >= item.length) {
			/* ����ó�� */
		} else {
			item[numItems++] = x;
		}
		
	}

	//�迭 ����Ʈ�� k��° ���� �����ϱ� 
	@Override
	public Integer remove(int index) {
		if(isEmpty() || index < 0 || index > numItems - 1)
			return null;
		else {
			Integer tmp = item[index];
			for (int i = index; i <= numItems -2; i++)
				item[i] = item[i+1]; //�� ����Ʈ
			numItems--;
			return tmp;
		}
	}

	//�迭 ����Ʈ���� ���� x �����ϱ�
	@Override
	public boolean removeItem(Integer x) {
		int k = 0;
		while (k < numItems && item[k].compareTo(x) != 0)
			k++;
		if(k ==numItems)
			return false;
		else {
			for (int i = k; i <= numItems -2; i++)
				item[i] = item[i+1]; //�� ����Ʈ
			numItems--;
			return true;
		}
	}

	//�迭 ����Ʈ�� i���� ���� �˷��ֱ�
	@Override
	public Integer get(int index) {
		if(index >= 0 && index <= numItems - 1)
			return item[index];
		else
			return null;
	}

	//�迭 ����Ʈ��  i���� ��Ҹ� x�� ��ü�ϱ� 
	@Override
	public void set(int index, Integer x) {
		if(index >= 0 && index <= numItems -1)
			item[index] = x;
		else {/* ����ó�� */}
		
	}

	//���� x�� �迭 ����Ʈ�� �� ��° �������� �˷��ֱ�
	private final int NOT_FOUND = -12345;
	@Override
	public int indexOf(Integer x) {
		int i = 0;
		for (i = 0; i <numItems; i++) {
			if(((Comparable)item[i]).compareTo(x) == 0)
				return i;
		}
		return NOT_FOUND; //�������� �ʴ´ٸ� 
	}

	//�迭 ����Ʈ�� �� ���� �� �˷��ֱ� 
	@Override
	public int len() {
		return numItems;
	}

	//�迭 ����Ʈ�� ������� �˷��ֱ�
	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}

	//�迭 ����Ʈ ������ û���ϱ�
	@Override
	public void clear() {
		item = new Integer[item.length];
		numItems = 0;
		
	}
	

}
