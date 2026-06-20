# 7. Develop a simple rule-based expert system that recommends food based on preferences.

rules = [
    {'conditions': {'vegetarian': True,  'spicy': True},  'food': 'Paneer Tikka'},
    {'conditions': {'vegetarian': True,  'spicy': False}, 'food': 'Veg Salad'},
    {'conditions': {'vegetarian': False, 'spicy': True},  'food': 'Spicy Chicken Curry'},
    {'conditions': {'vegetarian': False, 'spicy': False}, 'food': 'Grilled Fish'},
]

def recommend(prefs):
    for rule in rules:
        if all(prefs.get(k) == v for k, v in rule['conditions'].items()):
            return rule['food']
    return 'No recommendation found.'

vegetarian = input("Are you vegetarian? (yes/no): ").strip().lower() == 'yes'
spicy      = input("Do you like spicy food? (yes/no): ").strip().lower() == 'yes'

print("Recommended Food:", recommend({'vegetarian': vegetarian, 'spicy': spicy}))
