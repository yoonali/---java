package list;

public class ArrayList<E> implements ListInterface<E> {

	private E item[];
	private int numItems;
	//상수 구현
	private static final int DEFAULT_CAPACITY = 64;
	
	public ArrayList() {
		item = (E[]) new Object[DEFAULT_CAPACITY];
		numItems = 0;
	}
	
	public ArrayList(int n) {
		item = (E[]) new Object[n];
		numItems = 0;
	}
	
	//배열 리스트의 k번째 자리에 원소 x 삽입하기 
		@Override
		public void add(int index, E x) {
			if(numItems >= item.length || index < 0 || index > numItems) {
				/* 에러처리 */
			} else {
				for (int i = numItems - 1; i>= index; i--) 
					item[i + 1] = item[i]; //우시프트
				item[index] = x;
				numItems++;
			}
			
		}

		//배열 리스트의 맨 뒤에 원소 추가하기 
		@Override
		public void append(E x) {
			if(numItems >= item.length) {
				/* 에러처리 */
			} else {
				item[numItems++] = x;
			}
			
		}

		//배열 리스트의 k번째 원소 삭제하기 
		@Override
		public E remove(int index) {
			if(isEmpty() || index < 0 || index > numItems - 1)
				return null;
			else {
				E tmp = item[index];
				for (int i = index; i <= numItems -2; i++)
					item[i] = item[i+1]; //좌 시프트
				numItems--;
				return tmp;
			}
		}

		//배열 리스트에서 원소 x 삭제하기
		@Override
		public boolean removeItem(E x) {
			int k = 0;
			while (k < numItems && ((Comparable)item[k]).compareTo(x) != 0)
				k++;
			if(k ==numItems)
				return false;
			else {
				for (int i = k; i <= numItems -2; i++)
					item[i] = item[i+1]; //좌 시프트
				numItems--;
				return true;
			}
		}

		//배열 리스트의 i번쨰 원소 알려주기
		@Override
		public E get(int index) {
			if(index >= 0 && index <= numItems - 1)
				return item[index];
			else
				return null;
		}

		//배열 리스트의  i번쨰 언소를 x로 대체하기 
		@Override
		public void set(int index, E x) {
			if(index >= 0 && index <= numItems -1)
				item[index] = x;
			else {/* 에러처리 */}
			
		}

		//원소 x가 배열 리스트의 몇 번째 원소인지 알려주기
		private final int NOT_FOUND = -12345;
		@Override
		public int indexOf(E x) {
			int i = 0;
			for (i = 0; i <numItems; i++) {
				if(((Comparable)item[i]).compareTo(x) == 0)
					//객체는 단순한 수가 아니므로 !=, == 같은 기초 연산자 쓸 수 없음 이런 경우 비교를 위해 쓰는 인터페이스 Comparable (요구하는 메서는 compareTo()하나)
					return i;
			}
			return NOT_FOUND; //존재하지 않는다면 
		}

		//배열 리스트의 총 원소 수 알려주기 
		@Override
		public int len() {
			return numItems;
		}

		//배열 리스트가 비었는지 알려주기
		@Override
		public boolean isEmpty() {
			return numItems == 0;
		}

		//배열 리스트 깨끗이 청소하기
		@Override
		public void clear() {
			item = (E[]) new Object[item.length];
			numItems = 0;
			
		}
}
