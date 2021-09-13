/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap_04_TIVI;

/**
 *
 * @author Manh Hai
 */
public class CTivi {
    private String[] channelList;
    private boolean isOn;
    private String currentChannel;
    
    public CTivi() {
        isOn = false;
        channelList = new String[3];
        channelList[0] = "VTV1";
        channelList[1] = "VTV2";
        channelList[2] = "VTV3";
        
        currentChannel = "VTV1";
    }
    
    public CTivi(String[] channelList) {
        this.channelList = channelList;
        isOn = false;
        currentChannel = channelList[0]; 
    }
    
    private String searchNextChannel(boolean isForword) {
        int currrentIndex = -1;
        for(int i = 0; i < channelList.length; i++) {
            if(channelList[i].equalsIgnoreCase(currentChannel)) {
                currrentIndex = i;
                break;
            }
        }
        if(isForword) {
            currrentIndex++;
            if(currrentIndex >= channelList.length) {
                currrentIndex = 0;
            }
        } else {
            currrentIndex--;
            if(currrentIndex < 0) {
                currrentIndex = channelList.length -1;
            }
        }
        currentChannel = channelList[currrentIndex];
        return currentChannel;
    }
    
    public void On() {
        isOn = true;
        System.out.println("---Tivi ON---");
    }
    
    public void Off() {
        isOn = false;
        System.out.println("---Tivi OFF---");
    }
    
    public void Switch() {
        if(isOn) {
            Off();
        } else {
            On();
        }
    }
    
    public void Switch(String channel) {
        if(isOn) {
            boolean isFind = false;
            for(int i = 0; i < channelList.length; i++) {
                if(channelList[i].equalsIgnoreCase(channel)) {
                    isFind = true;
                    break;
                }
            }
            if(isFind) {
                currentChannel = channel;
                System.out.println("The channel is playing on " + currentChannel);
            } else {
                System.err.println("Not found this channel.");
            }
        }
    }
    
    public void nextChannel() {
        if(isOn) {
            searchNextChannel(true);
            System.out.println("The channel is playing on " + currentChannel);
        }
    }
    
    public void previousChannel() {
        if(isOn) {
            searchNextChannel(false);
            System.out.println("The channel is playing on " + currentChannel);
        }
    }
    
    public void showTivi() {
        if(isOn) {
            System.out.printf("---Tivi is On at channel: %s---", currentChannel); 
            System.out.println("");
        } else {
            System.out.println("---Tivi now OFF---");
        }
    }
}
