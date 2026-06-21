# 8. Implement a Naive Bayes classifier to classify messages as spam or ham.
import math

class NaiveBayesClassifier:
    def fit(self, X, y):
        n = len(X)
        classes = set(y)
        self.class_probs = {c: y.count(c) / n for c in classes}
        word_count  = {c: {} for c in classes}
        total_words = {c: 0  for c in classes}

        for msg, label in zip(X, y):
            for word in msg.split():
                word_count[label][word] = word_count[label].get(word, 0) + 1
                total_words[label] += 1

        vocab = set(w for c in word_count for w in word_count[c])
        self.word_probs = {
            word: {c: (word_count[c].get(word, 0) + 1) / (total_words[c] + len(vocab))
                   for c in classes}
            for word in vocab
        }
        self.classes = classes

        print(f"Vocabulary size : {len(vocab)}")
        print(f"Class Probabilities:")
        for c in sorted(classes):
            print(f"  P({c}) = {self.class_probs[c]:.2f}")

    def predict(self, message):
        scores = {c: math.log(self.class_probs[c]) for c in self.classes}
        for word in message.split():
            if word in self.word_probs:
                for c in self.classes:
                    scores[c] += math.log(self.word_probs[word][c])
        label = max(scores, key=scores.get)
        return label, scores

X_train = [
    "send us your password", "send us your review",
    "send us your account",  "Review your password",
    "send your password",    "Review us"
]
y_train = ['spam', 'ham', 'spam', 'ham', 'spam', 'ham']
X_test  = ["Your activity report", "renew your password"]

print("=" * 50)
print("     LAB 8 Naive Bayes Spam Classifier by Pitam")
print("=" * 50)
print(f"\nTraining on {len(X_train)} messages ({y_train.count('spam')} spam, {y_train.count('ham')} ham)\n")

clf = NaiveBayesClassifier()
clf.fit(X_train, y_train)

print("\n--- Predictions ---")
for msg in X_test:
    label, scores = clf.predict(msg)
    print(f"\n  Message : '{msg}'")
    # for c in sorted(scores):
    #     print(f"    log P({c}|msg) = {scores[c]:.4f}")
    print(f"  Predicted : {label.upper()}")
