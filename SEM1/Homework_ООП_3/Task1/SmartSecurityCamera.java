package SEM1.Homework_ООП_3.Task1;

public class SmartSecurityCamera extends SmartDevice{
    private boolean isRecording;
    private boolean motionDetection;
    private String videoQuality;

    public SmartSecurityCamera(String deviceId, String deviceName, String location, boolean isPoweredOn, double powerConsumption, boolean isRecording, boolean motionDetection, String videoQuality) {
        super(deviceId, deviceName, location, isPoweredOn, powerConsumption);
        setIsRecording(isRecording);
        setMotionDetection(motionDetection);
        setVideoQuality(videoQuality);
    }

    @Override
    public String getDeviceType() {
        return "Умная камера";
    }

    @Override
    public void performAction() {
        setIsRecording(!getIsRecording());
    }

    public void startRecording() {
        setIsRecording(true);
    }

    public void startRecording(boolean motionDetection) {
        startRecording();
        setMotionDetection(motionDetection);
    }

    public void detectMotion() {
        setMotionDetection(true);
    }

    public void getLiveFeed() {
        setIsRecording(true);
    }


    public boolean getIsRecording() {
        return isRecording;
    }

    public void setIsRecording(boolean recording) {
        isRecording = recording;
    }

    public boolean GetMotionDetection() {
        return motionDetection;
    }

    public void setMotionDetection(boolean motionDetection) {
        this.motionDetection = motionDetection;
    }

    public String getVideoQuality() {
        return videoQuality;
    }

    public void setVideoQuality(String videoQuality) {
        this.videoQuality = videoQuality;
    }
}
