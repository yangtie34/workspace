package modelObject;

import java.util.List;

public class InOutModel {
	private Object in;//输入
	private List<InOutModel> nextLevels;//同步执行其他流程
	private Object action;//执行
	private Object out;//输出
}
