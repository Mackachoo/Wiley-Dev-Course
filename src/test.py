# Author : Dan B
# Date: 16/04/2024


class FoodItem:
    def __init__(self) -> None:
        self.type = type(self).__name__
        self.components = {}

    def price(self):
        return sum([comp[0] * comp[1] for comp in self.components.values()])

    def __str__(self) -> str:
        output = ""
        for i in self.components.keys():
            output += f"\n{i.capitalize()} : {self.components[i][0]} x £{self.components[i][1]:.2f}"
        output += "\n----------------\n"
        output += f"{self.type} : £{self.price()}"
        return output


class Burger(FoodItem):
    def __init__(self) -> None:
        super().__init__()
        self.add_patty()
        self.add_extras()
        self.add_sauce()

    def add_patty(self):
        patty = ""
        number = 0
        while patty not in ["beef", "chicken", "vegan"]:
            patty = input(
                "Would like a Beef (£3), Chicken (£2.5) or Vegan (£2.5) patty?"
            ).lower()
        while number not in range(1, 4):
            try:
                number = int(input("How many patties would you like (1-4)?"))
            except:
                continue

        self.components[patty] = (number, 3 if patty == "beef" else 2.5)

    def add_extras(self):
        while True:
            extra = "None"
            while extra not in [
                "cheese",
                "bacon",
                "lettuce",
                "tomato",
                "onion",
                "",
            ]:
                choice = input(
                    "Add extras to your burger (add double before the item to add double the amount):\nWould you like to add cheese, bacon, lettuce, tomato or onion (each £1)?"
                ).lower()
                num, extra = (
                    ((2, 1), choice.split(" ")[1])
                    if " " in choice
                    else ((1, 1), choice)
                )

            if extra == "":
                break
            self.components[extra] = num
            print(f"Added {num} {extra} to your burger")

    def add_sauce(self):
        userIn, sauces = "None", []
        while len(sauces) == 0 and userIn != "":
            userIn = input(
                "Would you like to add ketchup, mayo, bbq or nothing (List each one, each 50p)?"
            ).lower()
            sauces = [
                s for s in userIn.split(" ") if s in ["ketchup", "mayo", "bbq", ""]
            ]
        if userIn != "":
            for sauce in sauces:
                self.components[sauce] = (1, 0.5)


class Drink(FoodItem):
    def __init__(self) -> None:
        super().__init__()
        self.add_drink()

    def add_drink(self):
        drink = ""
        while drink not in ["coke", "fanta", "sprite", "water", "coffee"]:
            drink = input(
                "Would you like a Coke (£1), Fanta (£1), Sprite (£1), Coffee (£1.5) or Water (£0.5)?"
            ).lower()
        self.components[drink] = (
            1,
            (1 if drink != "coffee" else 1.5) if drink != "water" else 0.5,
        )
        self.choose_size(drink)

    def choose_size(self, drink):
        size = ""
        while size not in ["small", "medium", "large"]:
            size = input(
                "Would you like a small, medium (+50p) or large drink (+£1)?"
            ).lower()
        self.components[size] = (
            1,
            (1 if size == "large" else 0.5 if size == "medium" else 0),
        )


class Side(FoodItem):
    def __init__(self) -> None:
        super().__init__()
        self.add_side()

    def add_side(self):
        side = ""
        while side not in ["fries", "salad", "onion rings"]:
            side = input(
                "Would you like Fries (£1), Salad (£1.5) or Onion Rings (£1.5)?"
            ).lower()
        self.components[side] = (1, 1 if side == "fries" else 1.5)


class Combo(FoodItem):
    def __init__(self) -> None:
        super().__init__()
        self.burger = Burger()
        self.drink = Drink()
        self.side = Side()

    def price(self):
        return (self.burger.price() + self.drink.price() + self.side.price()) * 0.8

    def __str__(self):
        output = f"{self.burger}\n{self.drink}\n{self.side}"
        output += "\n================\n"
        output += f"{self.type} : £{self.price()}"
        return output


class Order:
    def __init__(self) -> None:
        self.food_items = []

    def add_food_item(self):
        choice = input("Would you like to add a burger, drink, side or combo?").lower()
        match choice:
            case "burger":
                item = Burger()
            case "drink":
                item = Drink()
            case "side":
                item = Side()
            case "combo":
                item = Combo()
        self.food_items.append(item)

    def total_price(self):
        return sum([food_item.price() for food_item in self.food_items])

    def __str__(self):
        output = ""
        for item in self.food_items:
            output += str(item) + "\n"
        return output


def take_order():
    # ask user for name for the order
    # repeat taking order until client is done
    # display order details
    # display a thank you message
    print("Welcome to Burger Shop")

    name = input("What is your name?")

    order = Order()
    while True:
        order.add_food_item()
        print(order)
        if "y" not in input("Would you like to add another item?").lower():
            break

    print(f"\n\n-- Final Order for {name} --")
    print(order)


take_order()