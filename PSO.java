/*TSP���⣺������һ����������Ҫ�ݷ�N�����У�
 * ������ѡ����Ҫ�ߵ�·����·����������ÿ������ֻ�ܰݷ�һ��
 * �������Ҫ�ص�ԭ�������ĳ��С�·����ѡ��Ŀ����Ҫ��õ�·��·��Ϊ����·��֮�е���Сֵ
 * ����Ⱥ�㷨PSO��
 * ��ϵͳ��ʼ��Ϊһ������⣬
 * ͨ��������Ѱ����ֵ��������û���Ŵ��㷨�õĽ���(crossover)�Լ�����(mutation)
 * �����������ڽ�ռ�׷�����ŵ����ӽ���������
 * ���ογ���ƣ���48���е�TSP����Ϊ�����������ۻ�������Ⱥ�㷨���TSP����
 * ���������������������Ⱥ����ģ��
 */
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PSO {
	private int vPgd;//���Ž������ֵ
	private int bestT;//�������Ž�Ĵ���
    private int[] fitness;//��Ⱥ��Ӧ�ȣ�ÿ���������Ӧ��
	private Random random;
	private int BN;
	private float w;//Ȩ��
	private int MAX;//��������
	private int scale;//��Ⱥ��ģ
	private int citynumber;//��������
	private int t;//Ŀǰ�Ĵ���
	private int [][] distance;//�������
	private int [][] OP;//����Ⱥ
	private ArrayList<ArrayList<PTO>> listV;//ÿ�����ӵĳ�ʼ��������
	private int [][] Pd;//һ�������ڸ����г��ֵ����Ž�
	private int[] VPD;//�������ֵ
	private int[] Pgd;//ÿ�������������ĸ����У�����ס�����Ž�
	private BufferedReader data;
   public PSO() {
   }
public  PSO(int n, int g, int s, float w) {
		this.citynumber= n;
		this.MAX = g;
		this.scale = s;
		this.w = w;
	}
   private void init(String filename) throws IOException {
	   //��ȡ����
		int[] x;
		int[] y;
		String s;
		data = new BufferedReader(new InputStreamReader(
				new FileInputStream(filename)));
		distance = new int[citynumber][citynumber];
		x = new int[citynumber];
		y = new int[citynumber];
		for (int i = 0; i < citynumber; i++) {
			s = data.readLine();
			String[] str = s.split(" ");//�ָ��ַ���
			x[i] = Integer.valueOf(str[1]);//X����
			y[i] = Integer.valueOf(str[2]);//Y����
		}
		for (int i = 0; i < citynumber - 1; i++) {
			//����������
			distance[i][i] = 0; 
			for (int j = i + 1; j < citynumber; j++) {
				double rp = Math
						.sqrt(((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j])
								* (y[i] - y[j])) / 10.0);//αŷʽ��ʽ
				int tp = (int) Math.round(rp);//�������룬ȡ����
				if (tp < rp) {
					distance[i][j] = tp + 1;
					distance[j][i] = distance[i][j];
				} 
				else {
					distance[i][j] = tp;
					distance[j][i] = distance[i][j];
				}
			}
		}
		distance[citynumber - 1][citynumber - 1] = 0;
		OP = new int[scale][citynumber];
		fitness = new int[scale];
		Pd = new int[scale][citynumber];
		VPD = new int[scale];
		Pgd = new int[citynumber];
		vPgd = Integer.MAX_VALUE;
		bestT = 0;
		t = 0;
		random = new Random(System.currentTimeMillis());
   }
   void initGroup() {
	   //��ʼ����Ⱥ
		int i, j, k;
		for (k = 0; k < scale; k++)//��Ⱥ����
		{
			OP[k][0] = random.nextInt(65535) % citynumber;
		
			for (i = 1; i <citynumber;)//���Ӹ���
			{
				OP[k][i] = random.nextInt(65535) % citynumber;
				for (j = 0; j < i; j++) {
					if (OP[k][i] == OP[k][j]) {
						break;
					}
				}
				if (j == i) {
					i++;
				}
			}
		}
   }

   void initListV() {
		int ra;
		int raA;
		int raB;
		listV = new ArrayList<ArrayList<PTO>>();
        	for (int i = 0; i < scale; i++) {
			ArrayList<PTO> list = new ArrayList<PTO>();
			ra = random.nextInt(65535) % citynumber;
			for (int j = 0; j < ra; j++) {
				raA = random.nextInt(65535) % citynumber;
				raB = random.nextInt(65535) % citynumber;
				while (raA == raB) {
					raB = random.nextInt(65535) % citynumber;
				}
				PTO s = new PTO(raA, raB);
				list.add(s);
			}

			listV.add(list);
		}
	}

	public int evaluate(int[] chr) {
		int len = 0;
		//���б���
		for (int i = 1; i < citynumber; i++) {
			len += distance[chr[i - 1]][chr[i]];
		}
		len += distance[chr[citynumber - 1]][chr[0]];
		return len;
	}
	// ��һ�������������������ڱ���arr��ı���
	public void add(int[] arr, ArrayList<PTO> list) {
		int temp = -1;
		PTO s;
		for (int i = 0; i < list.size(); i++) {
			s = list.get(i);
			temp = arr[s.getX()];
			arr[s.getX()] = arr[s.getY()];
			arr[s.getY()] = temp;
		}
	}
	//����������Ļ�����������
	public ArrayList<PTO> minus(int[] a, int[] b) {
		int[] temp = b.clone();
		int index;//������
		PTO s;//��������
		ArrayList<PTO> list = new ArrayList<PTO>();
		for (int i = 0; i < citynumber; i++) {
			if (a[i] != temp[i]) {
				// ��temp���ҳ���a[i]��ͬ��ֵ���±�index
				index = findnumber(temp, a[i]);
				// ��temp�н����±�i���±�index��ֵ
				changeIndex(temp, i, index);
				//��ס������
				s = new PTO(i, index);
				//���潻����
				list.add(s);
			}
		}
		return list;
	}
	// ��arr�����в���number������number���±�
	public int findnumber(int[] arr, int num) {
		int index = -1;
		for (int i = 0; i < citynumber; i++) {
			if (arr[i] == num) {
				index = i;
				break;
			}
		}
		return index;
	}
	// ������arr�±�index1���±�index2��ֵ����
	public void changeIndex(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	//��ά����copy
	public void copyarr(int[][] from, int[][] to) {
		for (int i = 0; i < scale; i++) {
			for (int j = 0; j < citynumber; j++) {
				to[i][j] = from[i][j];
			}
		}
	}
	//һά����copy
	public void copyarraynumber(int[] from, int[] to) {
		for (int i = 0; i < citynumber; i++) {
			to[i] = from[i];
		}
	}
	
	public void evolution() {
		int i, j, k;
		int len = 0;
		float ra = 0f;
		ArrayList<PTO> Vi;
		//����һ��
		for (t = 0; t < MAX; t++) {
			//ÿ������
			for (i = 0; i < scale; i++) {
				if(i==BN) continue;
				ArrayList<PTO> Vii = new ArrayList<PTO>();
				// �����ٶ�
				// Vii=wVi+ra(Pid-Xid)+rb(Pgd-Xid)
				Vi = listV.get(i);
				// wVi+��ʾ��ȡVi��size*wȡ������������
				len = (int) (Vi.size() * w);
				for (j = 0; j < len; j++) {
					Vii.add(Vi.get(j));
				}
				// Pid-Xid
				ArrayList<PTO> a = minus(Pd[i], OP[i]);
				ra = random.nextFloat();
				// ra(Pid-Xid)
				len = (int) (a.size() * ra);
				for (j = 0; j < len; j++) {
					Vii.add(a.get(j));
				}
				ArrayList<PTO> b = minus(Pgd, OP[i]);
				ra = random.nextFloat();
				len = (int) (b.size() * ra);
				for (j = 0; j < len; j++) {
					PTO tt= b.get(j);
					Vii.add(tt);
				}
				// ������Vii
				listV.add(i, Vii);
				//Xid��=Xid+Vid
				add(OP[i], Vii);
			}
			// ����������Ⱥ��Ӧ�ȣ�Fitness[max],ѡ����õĽ�
			for (k = 0; k < scale; k++) {
				fitness[k] = evaluate(OP[k]);
				if (VPD[k] > fitness[k]) {
					VPD[k] = fitness[k];
					copyarraynumber(OP[k], Pd[k]);
					BN=k;
				}
				if (vPgd > VPD[k]) {
					System.out.println("��ѳ���"+vPgd+" ������"+bestT);
					bestT = t;
					vPgd = VPD[k];
					copyarraynumber(Pd[k], Pgd);
				}
			}		
		}
	}

	public void solve() {
		int i;
		int k;
		initGroup();
		initListV();
		//ÿ�������������ĸ����У�����ס�����Ž�
		copyarr(OP, Pd);
		// ����������Ⱥ��Ӧ�ȣ�Fitness[max],ѡ����õĽ�
		for (k = 0; k < scale; k++) {
			fitness[k] = evaluate(OP[k]);
			VPD[k] = fitness[k];
			if (vPgd > VPD[k]) {
				vPgd = VPD[k];
				copyarraynumber(Pd[k], Pgd);
				BN=k;
			}
		}
		System.out.println("��ʼ��");
		for (k = 0; k < scale; k++) {
			for (i = 0; i < citynumber; i++) {
				System.out.print(OP[k][i] + ",");
			}
			System.out.println();
			System.out.println("----------------->"+fitness[k]);
		evolution();//����
		System.out.println("�����");
		for (k = 0; k < scale; k++) {
			for (i = 0; i < citynumber; i++) {
				System.out.print(OP[k][i] + ",");
			}
			System.out.println();
			System.out.println("-------------------->" + fitness[k]);
		System.out.println("��ѳ��ȳ��ִ�����");
		System.out.println(bestT);
		System.out.println("��ѳ���");
		System.out.println(vPgd);
		System.out.println("���·����");
		for (i = 0; i < citynumber; i++) {
			System.out.print(Pgd[i] + ",");
		}
	}
  }
}
	public static void main(String[] args) throws IOException {
		System.out.println("���Կ�ʼ");
		PSO pso = new PSO(48, 6000, 30, 0.5f);
		pso.init("D://1.txt");//����������Դ
		//http://elib.zib.de/pub/Packages/mp-testdata/tsp/tsplib/tsp/att48.tsp
		pso.solve();
	}

class PTO extends PSO
{
	private int x;
	private int y;

	public PTO(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void print()
	{
		System.out.println("x:"+this.x+" y:"+this.y);
	}
}
}