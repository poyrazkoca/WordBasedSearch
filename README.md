# Elasticsearch Word-Based Search Backend #
# Overview
This backend project provides a word-based search functionality using Elasticsearch, specifically for tracking and retrieving the time intervals where certain words are spoken in videos. It is designed to support platforms where users watch films, live events, news, movies, and series with subtitle integrations. By searching for a word, users can get the exact time intervals (start and end times) where the word appears in a subtitle track.

The backend leverages Elasticsearch to efficiently index and search for words in subtitles, making it easy to locate specific dialogue or terms within any video content.

# Features
Word-Based Search: Input a word to retrieve all time intervals (start and end times) where it appears in a video’s subtitles.
Video Subtitle Integration: Easily integrates with platforms that support subtitle tracks, allowing for precise word searching within any video.
Time-Based Results: Outputs the start and end times for each occurrence of the word, so users can jump directly to the point in the video where the word is spoken.
Optimized for Media Platforms: Suitable for platforms with extensive subtitle content, such as streaming services for films, series, news, and live events.

# How It Works
Indexing Subtitles:

Subtitles for each video are processed and indexed in Elasticsearch.
Each word in the subtitle is associated with its corresponding start_time and end_time within the video.

Search Query:

When a search request is made for a specific word (e.g., "Millet"), the backend searches Elasticsearch for that word in the indexed subtitle data.
If the word is found, the API returns the start_time and end_time for each occurrence, allowing precise navigation within the video.

# Technologies
Java: Core language for backend development.
Spring Boot: Framework for building and running the application.
Elasticsearch: Used for indexing and querying subtitle data, optimized for word-based search and retrieval.
Setup
Prerequisites
Java 8 or higher
Elasticsearch (compatible version)
Spring Boot dependencies

# Usage Example
Once the subtitles are indexed, you can search for any word, and the API will return the time intervals where the word appears in the video. This can be integrated into video playback platforms to enable users to jump directly to specific points in the content.
