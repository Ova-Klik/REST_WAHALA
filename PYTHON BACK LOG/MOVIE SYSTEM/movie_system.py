from datetime import datetime

movies = {}

def add_movie():
    name = input("Enter the movie name: ").strip().lower() 

    if not name:
        print("Movie name cannot be empty.")
        return

    if name in movies:
        print(f"Movie '{name}' already exists.")
        return

    movies[name] = {
        "ratings": [],
        "created_at": datetime.now()
    }

    print(f"Movie '{name}' added!")

def get_valid_rating():
    while True:
        try:
            rating = int(input("Enter your rating (1-5): "))
            if 1 <= rating <= 5:
                return rating
            else:
                print("Rating must be between 1 and 5.")
        except ValueError:
            print("Invalid input. Enter a number.")


def rate_movie():
    name = input("Enter the movie name: ").strip().lower()

    if name not in movies:
        print(f"Movie '{name}' not found.")
        return

    rating = get_valid_rating()
    movies[name]["ratings"].append(rating)

    print(f"Rating added for '{name}' → {rating}")


def view_average_ratings():
    if not movies:
        print("No movies available.")
        return

    print("\nAverage Ratings:")
    for name, data in movies.items():
        ratings = data["ratings"]
        avg = sum(ratings) / len(ratings) if ratings else 0
        print(f"- {name.title()}: {avg:.1f}")

while True:
    print("\n1. Add a Movie")
    print("2. Rate a Movie")
    print("3. View Average Ratings")
    print("4. Exit")

    choice = int(input("Enter your choice: "))

    match choice:
        case 1: add_movie()

        case 2:
            rate_movie()

        case 3:
            view_average_ratings()

        case 4:
            print("Exiting the application. Goodbye!")
            break
        case _:
            print("Invalid choice. Try again.")
