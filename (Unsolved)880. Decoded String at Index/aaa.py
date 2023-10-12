from re import split

class twitch:
    def solution(input, language, category):
        # Please write your code here.
        streamers = []
        n = len(streamers) 
        res = []

        for i, streamer in enumerate(input):
            arr = streamer.split("-")
            streamers.append(arr)
        

        if language == 'null': #only check for category
            for i, streamer in enumerate(streamers):
                if streamer[2] == category:
                    res.append(streamer[0])
        elif category == 'null': #only check for language
            for i, streamer in enumerate(streamers):
                if streamer[1] == language:
                    res.append(streamer[0])
        else: 
            for i, streamer in enumerate(streamers):
                if streamer[1] == language and streamer[2] == category:
                    res.append(streamer[0])
        return res

inst = twitch
inst.solution(["pokimane-English-Valorant", "Dream-English-Minecraft", "k4sen-Japanese-League of Legends", "tommyinnit-English-Minecraft", "QTCinderella-English-Just Chatting"], "English", "Minecraft")