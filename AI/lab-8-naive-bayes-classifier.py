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

    def predict(self, message):
        scores = {c: math.log(self.class_probs[c]) for c in self.classes}
        for word in message.split():
            if word in self.word_probs:
                for c in self.classes:
                    scores[c] += math.log(self.word_probs[word][c])
        return max(scores, key=scores.get)

X_train = [
    "send us your password", "send us your review",
    "send us your account",  "Review your password",
    "send your password",    "Review us"
]
y_train = ['spam', 'ham', 'spam', 'ham', 'spam', 'ham']
X_test  = ["Your activity report", "renew your password"]

clf = NaiveBayesClassifier()
clf.fit(X_train, y_train)
for msg in X_test:
    print(f"'{msg}' -> {clf.predict(msg)}")
