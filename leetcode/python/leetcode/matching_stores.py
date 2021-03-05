group_one = ["fred_meyer", "winco", "albertsons"]
group_two = ["fred_meyer", "cirle_k", "albertsons"]

stores = [group_one, group_two]
"""
fred_meyer {
    winco: 1,
    albertsons: 2,
    circle_k: 1
}

winco {
    fred_meyer: 1,
    albertsons: 1
}

"""


print(stores)