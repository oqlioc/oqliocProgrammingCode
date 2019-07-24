package decorator;

public class Client {
	public static void main(String[] args) {
		// 기본 도로 표시 + 차선 표시 + 교통량 표시 + 교차로 표시
		Display roadWithCrossingLaneAndTraffic = 
				new LaneDecorator(
						new TrafficDecorator(
								new CrossingDecorator(
										new RoadDisplay())));
		
		roadWithCrossingLaneAndTraffic.draw();
	}
}