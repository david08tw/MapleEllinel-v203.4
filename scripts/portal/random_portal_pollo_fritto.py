POLLO = 9001059
FRITTO = 9001060

ids = [POLLO, FRITTO]

text = {
    POLLO : "Hello, I am #rPollo#k the bounty hunter.\r\nMy brother #bFritto#k and I are the best at what we do! Ha ha!",
    FRITTO : "Hello, I am #bFritto#k the bounty hunter.\r\nMy brother #rPollo#k and I are the best at what we do! Ha ha!"
}

text2 = {
    POLLO : "People look at me and instantly see that I am not to be trifled with. How would you like to come with me"
            "and witness my greatness?\r\n#L0#Yeah, let's go.#l\r\n#L1#Nah, not now.#l",
    FRITTO : "Many people doubt my skills, but one look proves them wrong. How would you like to come with me and"
             "witness my greatness?\r\n#L0#Yeah, let's go.#l\r\n#L1#Nah, not now.#l"
}

maps = {
    POLLO : [
        993000000,
        993000100,
     ],
    FRITTO : [
        993000200,
        993000300,
        993000400,
    ]
}

rand = sm.getRandomIntBelow(2)
npc = ids[rand]
sm.setSpeakerID(npc)
sm.sendNext(text[npc])
answer = sm.sendNext(text2[npc])
if answer == 0:
    chr.setPreviousFieldID(chr.getFieldID())
    map = maps[npc][sm.getRandomIntBelow(len(maps[npc]))]
    sm.warpInstanceIn(map)
    chr.getField().removeLife(objectID, False)