# 8.Implement a Naive Bayes classifier to classify messages as spam or ham.

class NaiveBayesClassifier:
    def __init__(self):
        self.class_probs = {}
        self.word_probs = {}

    def fit(self, X, y):
        num_samples = len(X)
        num_spam = sum(1 for label in y if label == 'spam')
        num_ham = num_samples - num_spam

        # Calculate class probabilities
        self.class_probs['spam'] = num_spam / num_samples
        self.class_probs['ham'] = num_ham / num_samples

        # Calculate word probabilities for spam and ham
        spam_word_count = {}
        ham_word_count = {}
        total_spam_words = 0
        total_ham_words = 0

        for message, label in zip(X, y):
            words = message.split()
            for word in words:
                if label == 'spam':
                    spam_word_count[word] = spam_word_count.get(word, 0) + 1
                    total_spam_words += 1
                else:
                    ham_word_count[word] = ham_word_count.get(word, 0) + 1
                    total_ham_words += 1

        vocab = set(spam_word_count.keys()).union(set(ham_word_count.keys()))

        for word in vocab:
            spam_prob = (spam_word_count.get(word, 0) + 1) / (total_spam_words + len(vocab)) # laplace smoothing is applied here
            ham_prob = (ham_word_count.get(word, 0) + 1) / (total_ham_words + len(vocab))
            self.word_probs[word] = {'spam': spam_prob, 'ham': ham_prob}

    def predict(self, message):
        spam_score = math.log(self.class_probs['spam'])
        ham_score = math.log(self.class_probs['ham'])

        words = message.split()
        for word in words:
            if word in self.word_probs:
                spam_score += math.log(self.word_probs[word]['spam'])
                ham_score += math.log(self.word_probs[word]['ham'])

        if spam_score > ham_score:
            return 'spam'
        else:
            return 'ham'

# Training data
X_train = [
    "send us your password",
    "send us your review",
    "send us your account",
    "Review your password",
    "send your password",
    "Review us"
]
y_train = ['spam', 'ham', 'spam', 'ham', 'spam', 'ham']

# Test data
X_test = [
    "Your activity report",
    "renew your password"
]

# Create and train the Naive Bayes classifier
clf = NaiveBayesClassifier()
clf.fit(X_train, y_train)

# Predict
for message in X_test:
    prediction = clf.predict(message)
    print(f"Message: {message} -> Predicted label: {prediction}")