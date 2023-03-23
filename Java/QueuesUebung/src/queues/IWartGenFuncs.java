package queues;

public interface IWartGenFuncs<T>
{
	void setNaechster(T p);
	T getNaechster();
	void delItem(T p);
}
