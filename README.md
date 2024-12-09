# CaseyleonardLab1
The LAB1 Package and the associated UML can be found in the Master branch of this Git repository. The LAB1 package consists of several core classes: articles, stopwords, wordstats, AddArticles, Vocabulary, and Attitude. This package allows users to select an article topic, read the corresponding articles, remove stop words, and analyze word frequencies. Additionally, users can add new articles to the system under a specified topic, analyze the sentiment of articles, and find the article with the richest vocabulary.

Classes
articles
•	Prompts the user to choose an article topic: football, soccer, or basketball.
•	Reads the selected articles from files in the chosen topic folder.
•	Displays the original and modified articles (after removing stop words).
•	Calculates and displays word statistics before and after removing stop words.
•	Analyzes sentiment of the articles based on positive and negative word lists.
•	Identifies the article with the richest vocabulary.
stopwords
•	Loads stop words from stopwords file.
•	Removes stop words from a given list of words.
wordstats
•	Calculates word frequencies in a given list of words.
•	Sorts words by frequency.
•	Displays word frequencies and counts total and unique words.
Vocabulary
•	Analyzes the vocabulary richness of articles.
•	Identifies the article with the richest vocabulary in the given folder.
•	Can also find the top N most repeated words in the articles.
Attitude
•	Analyzes the sentiment of articles based on positivewords.txt and negativewords.txt list files.
•	Can classify articles as having a positive or negative sentiment based on the words contained in the articles.
AddArticles
•	Allows users to add new articles to the system.
•	Prompts the user to select a topic (football, soccer, or basketball).
•	Accepts file paths for new articles and moves them to the appropriate topic folder.

Usage
1.	Running the Program
Run the articles class to interact with the program. It will prompt the user to choose a topic and then display word statistics, sentiment analysis, and the article with the richest vocabulary.
2.	Adding New Articles
To add a new article to the system, run the AddArticles class. It will prompt you to select a topic and provide the path of the article you wish to add. The article will then be moved to the correct topic folder.
3.	Word Statistics
The program will display statistics about word frequencies before and after removing stop words. It will also show unique non-stop words and the article with the richest vocabulary.
4.	Sentiment Analysis
For each article, the program will analyze sentiment based on predefined positive and negative word lists. The sentiment is classified as either positive or negative.
5.	Vocabulary Analysis
The program will identify the article with the richest vocabulary (i.e., the article with the most unique, non-repetitive words). It will also display the top N most repeated words in the selected topic folder.
