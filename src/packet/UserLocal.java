package packet;

import client.character.skills.LarknessManager;
import connection.OutPacket;
import enums.ChatMsgColour;
import handling.OutHeader;

/**
 * Created on 1/2/2018.
 */
public class UserLocal {

    public static OutPacket chatMsg(ChatMsgColour colour, String msg) {
        OutPacket outPacket = new OutPacket(OutHeader.CHAT_MSG);

        outPacket.encodeShort(colour.getVal());
        outPacket.encodeString(msg);

        return outPacket;
    }

    public static OutPacket jaguarActive(boolean active) {
        OutPacket outPacket = new OutPacket(OutHeader.JAGUAR_ACTIVE);

        outPacket.encodeByte(active);

        return outPacket;
    }

    public static OutPacket jaguarSkill(int skillID) {
        OutPacket outPacket = new OutPacket(OutHeader.JAGUAR_SKILL);

        outPacket.encodeInt(skillID);

        return outPacket;
    }

    public static OutPacket incLarknessReponse(LarknessManager larknessManager) {
        OutPacket outPacket = new OutPacket(OutHeader.INC_LARKNESS_RESPONSE);

        larknessManager.encode(outPacket);

        return outPacket;
    }

    public static OutPacket onRoyalGuardAttack(boolean attack) {
        OutPacket outPacket = new OutPacket(OutHeader.ROYAL_GUARD_ATTACK);

        outPacket.encodeByte(attack);

        return outPacket;
    }

    public static OutPacket onRWMultiChargeCancelRequest(byte unk, int skillID) {
        OutPacket outPacket = new OutPacket(OutHeader.SKILL_USE_RESULT);

        outPacket.encodeByte(unk);
        outPacket.encodeInt(skillID);

        return outPacket;
    }

    public static OutPacket onSetOffStateForOffSkill(int skillID) {
        OutPacket outPacket = new OutPacket(OutHeader.SET_OFF_STATE_FOR_OFF_SKILL);

        outPacket.encodeInt(skillID);

        return outPacket;
    }

    public static OutPacket onResetStateForOffSkill() {
        OutPacket outPacket = new OutPacket(OutHeader.RESET_STATE_FOR_OFF_SKILL);

        outPacket.encodeInt(0);

        return outPacket;

    }

    public static OutPacket onEffectRechargeAB() {
        OutPacket outPacket = new OutPacket(OutHeader.EFFECT);

        outPacket.encodeByte(0x31);
        outPacket.encodeByte(1);

        return outPacket;
    }

    public static OutPacket ModHayatoCombo(int amount) {
        OutPacket outPacket = new OutPacket(OutHeader.MOD_HAYATO_COMBO);

        outPacket.encodeInt(amount);

        return outPacket;
    }
}
