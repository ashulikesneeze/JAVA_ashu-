package D13;

public interface ExdRemoteController {
	public void powerOn();
	public void powerOff();
}

interface ExdTVRemoteController extends ExdRemoteController {
	//클래스만들때 코드가 길어서 보기가 힘든데, 인터페이스는 한눈에 기능들을 보기가 편하다(목차처럼)
	public void volumnUp();
	public void volumnDown();
	public void channelUp();
	public void channelDown();
	public void ChangeChannel(int num);
	
class ExdTVRemoteCon implements ExdTVRemoteController {
	
	private boolean power; //TV전원 상태 
	private int channel = 1;
	private int volumn = 0;
	private int maxChannel = 999;
	private int maxVolumn = 32;
	@Override
	public void powerOn() {
		power = true;
		System.out.println("전원이 켜졌습니다.");
	}

	@Override
	public void powerOff() {
		power = false;
		System.out.println("전원이 꺼졌습니다.");
	}

	@Override
	public void volumnUp() {
		//TV가 꺼져있으면 소리 올리지 마세요 
		if(!power) {
			return; 
		}
		++volumn;
		volumn = volumn > maxVolumn ? maxVolumn : volumn; 
		//if(volumn > maxVolumn) {
		//volumn = maxVolumn; }
		System.out.println("소리 : " + volumn);
	}

	@Override
	public void volumnDown() {
		if(!power) {
			return; 
		}
		--volumn;
		volumn = volumn < 0 ? 0 : volumn; 
		//if(volumn < 0) {
		//volumn = 0; }
		System.out.println("소리 : " + volumn);
	}

	@Override
	public void channelUp() {
		if(!power) {
			return; 
		}
		++channel;
		channel = channel > maxChannel ? maxChannel : channel;
		System.out.println("채널 : " + channel);
	}

	@Override
	public void channelDown() {
		if(!power) {
			return; 
		}
		--channel;
		channel = channel < 0 ? 0 : channel;
		System.out.println("채널 : " + channel);
	}

	@Override
	public void ChangeChannel(int num) {
		if(!power) {
			return; 
		}
		channel = maxChannel < num ? maxChannel : num;	
		System.out.println("채널 : " + channel);
	}
	public ExdTVRemoteCon(int maxVolumn, int maxChannel) {
		this.maxChannel = maxChannel;
		this.maxVolumn = maxVolumn;
	}
}
class ExdLGTvRemoteCon extends ExdTVRemoteCon{
	public final static String LOGO = "LG";
	public ExdLGTvRemoteCon(int maxVolumn, int maxChannel) {
		super(maxVolumn, maxChannel);
	}
}
class ExdSamSungTvRemoteCon extends ExdTVRemoteCon{
	public final static String LOGO = "SAMSUNG";
	public ExdSamSungTvRemoteCon(int maxVolumn, int maxChannel) {
		super(maxVolumn, maxChannel);
	}
}
}

