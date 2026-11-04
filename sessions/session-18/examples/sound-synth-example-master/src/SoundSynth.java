import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class SoundSynth {
//    public void makeSound(int numberOfTimesFullSinFuncPerSec, int durationMs) throws LineUnavailableException {
//        System.out.println(String.format("Starting to make sound %d at %d ms", numberOfTimesFullSinFuncPerSec, durationMs));
//        byte[] buf = new byte[2];
//        int frequency = 44100; //44100 sample points per 1 second
//        AudioFormat af = new AudioFormat((float) frequency, 16, 1, true, false);
//        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
//        sdl.open();
//        sdl.start();
//        // int durationMs = 1000;
//        // int numberOfTimesFullSinFuncPerSec = 441; //number of times in 1sec sin function repeats
//        for (int i = 0; i < durationMs * (float) 44100 / 1000; i++) { //1000 ms in 1 second
//            float numberOfSamplesToRepresentFullSin= (float) frequency / numberOfTimesFullSinFuncPerSec;
//            double angle = i / (numberOfSamplesToRepresentFullSin/ 2.0) * Math.PI;  // /divide with 2 since sin goes 0PI to 2PI
//            short a = (short) (Math.sin(angle) * 32767);  //32767 - max value for sample to take (-32767 to 32767)
//            buf[0] = (byte) (a & 0xFF); //write 8bits ________WWWWWWWW out of 16
//            buf[1] = (byte) (a >> 8); //write 8bits WWWWWWWW________ out of 16
//            sdl.write(buf, 0, 2);
//        }
//        sdl.drain();
//        sdl.stop();
//        }

    public void makeSound(WaveType type, int numberOfTimesFullFuncPerSec, int durationMs) throws LineUnavailableException {
        System.out.println(String.format("Starting to make sound %s %d at %d ms", type, numberOfTimesFullFuncPerSec, durationMs));
        byte[] buf = new byte[2];
        int frequency = 44100; //44100 sample points per 1 second
        AudioFormat af = new AudioFormat((float) frequency, 16, 1, true, false);
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open();
        sdl.start();
        // int durationMs = 1000;
        // int numberOfTimesFullSinFuncPerSec = 441; //number of times in 1sec sin function repeats
        for (int i = 0; i < durationMs * (float) frequency / 1000; i++) {
            float numberOfSamplesToRepresentFullFunc = (float) frequency / numberOfTimesFullFuncPerSec;
            double phase = (i % numberOfSamplesToRepresentFullFunc) / numberOfSamplesToRepresentFullFunc;

            double value = 0.0;

            switch (type) {
                case SINE  :
                    value = Math.sin(2 * Math.PI * phase);
                    break;

                case SQUARE:
                    value = (phase < 0.5) ? 1.0 : -1.0;
                    break;

                case TRIANGLE:
                    value = 4 * Math.abs(phase - 0.5) - 1;
                    break;

                case SAWTOOTH:
                    value = 2 * phase - 1;
                    break;
            }

            short a = (short) (value * 32767);
            buf[0] = (byte) (a & 0xFF);
            buf[1] = (byte) (a >> 8);
            sdl.write(buf, 0, 2);
        }

        sdl.drain();
        sdl.stop();
    }




}