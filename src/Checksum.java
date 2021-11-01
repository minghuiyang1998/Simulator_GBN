public class Checksum {
    /**
     * calculate the check sum of a packet.
     * @param packet
     * @return checksum
     */
    public int calculateChecksum(Packet packet) {
        int ret = packet.getSeqnum() + packet.getAcknum();
        String payload = packet.getPayload();
        int[] sack = packet.getSack();
        for(int i: sack)
            ret += i;
        for(int i = 0; i < payload.length(); i++) {
            ret += payload.charAt(i);
        }
        return ret;
    }

    public int calculateChecksum(int seqNum, int ackNum, String message, int[] sack) {
        int ret = seqNum + ackNum;
        for(int i: sack) ret += i;
        for(int i = 0; i < message.length(); i++) {
            ret += message.charAt(i);
        }
        return ret;
    }
}
