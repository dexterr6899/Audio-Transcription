<!-- Banner -->
<p align="center">
  <img src="https://img.shields.io/badge/AI--Powered-Audio%20Transcriber-00BFFF?style=for-the-badge&logo=springboot&logoColor=white" alt="Project Banner"/>
</p>

<h1 align="center">🎙️ AI-Powered Audio Transcriber</h1>
<p align="center">
  Built with Spring Boot & OpenAI Whisper API – turning voice into accurate, structured text.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.5.3-6DB33F?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/OpenAI-Whisper-purple?style=for-the-badge&logo=openai" />
  <img src="https://img.shields.io/badge/RESTful-API-ff69b4?style=for-the-badge&logo=apachespark" />
  <img src="https://img.shields.io/badge/Speech--to--Text-AI--Driven-orange?style=for-the-badge&logo=voice" />
</p>


# 🎙️ AI-Powered Audio Transcriber – Built with Spring Boot & OpenAI Whisper API

Welcome to an intelligent, production-ready **audio transcription microservice** powered by **Spring Boot** and **OpenAI's Whisper API**.

This system receives audio input (MP3/WAV) via REST and returns clean, structured text output in real time — perfect for:

✅ Meeting transcription  
✅ Voice note analysis  
✅ Call center logging  
✅ Accessibility tools  
✅ Podcast content extraction

---

## 🚀 Why This Matters

As audio-first platforms grow and accessibility becomes a priority, having a reliable backend to **convert voice to text** is mission-critical.

This service allows you to build scalable products that:
- Analyze conversations and meetings
- Power AI-driven voice assistants or chatbots
- Improve accessibility and UX with real-time transcripts
- Enable searchable archives for podcasts, calls, or notes

---

## 🧠 How It Works

1. 📥 Receive an audio file via a REST endpoint  
2. 🧠 Process it using OpenAI’s `audio.transcriptions` endpoint (Whisper model)  
3. 📤 Return JSON output with the full extracted transcription  

Built using clean **Controller–Service–Utility** layers, with modular components and production-ready error handling.

---

## ⚙️ Tech Stack

| Tool/Lib               | Purpose                              |
|------------------------|--------------------------------------|
| **Spring Boot 3.5.3**  | Core backend framework               |
| **Java 17**            | Language runtime                     |
| **OpenAI Whisper API** | AI-powered audio transcription       |
| **RESTful API Design** | Clean endpoints for uploading files  |
| **Multipart Upload**   | Accept MP3/WAV files via POST        |
| **Jackson**            | JSON response formatting             |

---

## 📬 Sample API Usage

### 🎧 `POST /api/v1/audio/transcribe`

**Request:**
- Content-Type: `multipart/form-data`
- Field: `file` = MP3/WAV file

**Response:**
json
{
  "filename": "meeting-notes.mp3",
  "transcription": "Thanks everyone for joining the call today..."
}

## 🧩 Architecture Overview
Layered design (Controller → Service → Client)

Modular OpenAI integration via REST template

Robust exception handling for file validation & API responses

Can be extended to support:

Chunked audio

Multi-language transcription

Long-form processing with delay queues

## 💬 Use Cases
🧑‍💼 Product teams building transcription features

🎙️ Podcasters looking for searchable content

🦻 Accessibility engineers enabling voice-to-text

🧠 AI startups working on NLP or sentiment analysis

## 🤝 Let's Connect
Interested in collaborating on AI-powered backend systems, voice analytics, or audio intelligence?

📬 Feel free to open issues, fork this repo, or reach out directly.

## 🏷️ Tags
springboot openai java17 audiotranscription whisperapi speech-to-text restapi microservices audioprocessing backend

## 📄 License
MIT License – Use it, modify it, break it, improve it 🔧

## 👨‍💻 Author
Made with ❤️ by @dexterr6899


