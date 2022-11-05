import basketball_dictionaries_db

class Player:
    team_list = []

    def __init__(self, data):
        self.name = data["name"]
        self.age = data["age"]
        self.position = data["position"]
        self.team = data["team"] 
        Player.team_list.append(self)
    
    def __repr__(self):
        return "Player: {}, {} y/o, pos: {}, team: {}".format(self.name, self.age, self.position, self.team)

    @classmethod
    def get_team(cls): 
        # print(f"There are {len(cls.team_list)} players in our DB.")
        for player in cls.team_list: 
            print(player)
            # print("=====================")
            # print(player.name)
            # print(player.age)
            # print(player.position)
            # print(player.team)
            # if player.team: 
            #     print(f"player is on {player.team}")



# Challenge #2:
player_kevin = Player(basketball_dictionaries_db.players[0])
player_jason = Player(basketball_dictionaries_db.players[1])
player_kyrie = Player(basketball_dictionaries_db.players[2])
print(player_kevin)
print(player_jason)
print(player_kyrie)

# # Challenge #3:

new_team = []

for player in basketball_dictionaries_db.players:
    # print(player)
    new_team.append(Player(player))

print(new_team)


# Ninja Bonus: 


for player in basketball_dictionaries_db.players: 
#     # print(player)
    Player(player)
    # print(Player(player))
Player.get_team()

