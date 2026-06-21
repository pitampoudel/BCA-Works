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

print("=" * 50)
print("   LAB 7 Rule-Based Food Recommendation System by Pitam")
print("=" * 50)

print("\nRules:")
for rule in rules:
    c = rule['conditions']
    veg   = "Vegetarian" if c['vegetarian'] else "Non-Vegetarian"
    spicy = "Spicy"      if c['spicy']      else "Not Spicy"
    print(f"  IF {veg} AND {spicy} -> {rule['food']}")

print("\n--- Test Cases ---")
test_cases = [
    {'vegetarian': True,  'spicy': True},
    {'vegetarian': True,  'spicy': False},
    {'vegetarian': False, 'spicy': True},
    {'vegetarian': False, 'spicy': False},
]
for prefs in test_cases:
    veg   = "Yes" if prefs['vegetarian'] else "No"
    spicy = "Yes" if prefs['spicy']      else "No"
    food  = recommend(prefs)
    print(f"  Vegetarian: {veg:<3}  Spicy: {spicy:<3}  ->  {food}")
