package cn.ashersu.omni.model.news;

import java.util.Map;

public class OpenAI {
    private final Map<Class, OpenAIConfig> globalCfgMap;

    private volatile CompletionService completions;

    private volatile AssistantService assistantService;

    private volatile FileService fileService;

    private volatile FineTuningService fineTuningService;

    private volatile ImageService imageService;

    private volatile MessageService messageService;

    private volatile ModelService modelService;

    private volatile EmbeddingService embeddingService;

    private volatile AudioService audioService;

    private volatile ModerationService moderationService;

    private volatile ThreadService threadService;

    private volatile RunService runService;

    private volatile BillingService billingService;

    public OpenAI(Map<Class, OpenAIConfig> globalCfgs) {
        this.globalCfgMap = globalCfgs;
    }

    public CompletionService completions() {
        if (completions == null) {
            synchronized (this) {
                if (completions == null) {
                    completions = new CompletionService(globalCfgMap.get(CompletionService.class));
                }
            }
        }
        return completions;
    }

    public AssistantService assistant() {
        if (assistantService == null) {
            synchronized (this) {
                if (assistantService == null) {
                    assistantService = new AssistantService(globalCfgMap.get(AssistantService.class));
                }
            }
        }
        return assistantService;
    }

    public FileService files() {
        if (fileService == null) {
            synchronized (this) {
                if (fileService == null) {
                    fileService = new FileService(globalCfgMap.get(FileService.class));
                }
            }
        }
        return fileService;
    }

    public FineTuningService fineTuning() {
        if (fineTuningService == null) {
            synchronized (this) {
                if (fineTuningService == null) {
                    fineTuningService = new FineTuningService(globalCfgMap.get(FineTuningService.class));
                }
            }
        }
        return fineTuningService;
    }

    public ImageService images() {
        if (imageService == null) {
            synchronized (this) {
                if (imageService == null) {
                    imageService = new ImageService(globalCfgMap.get(ImageService.class));
                }
            }
        }
        return imageService;
    }

    public MessageService messages() {
        if (messageService == null) {
            synchronized (this) {
                if (messageService == null) {
                    messageService = new MessageService(globalCfgMap.get(MessageService.class));
                }
            }
        }
        return messageService;
    }

    public ModelService models() {
        if (modelService == null) {
            synchronized (this) {
                if (modelService == null) {
                    modelService = new ModelService(globalCfgMap.get(ModelService.class));
                }
            }
        }
        return modelService;
    }

    public EmbeddingService embeddings() {
        if (embeddingService == null) {
            synchronized (this) {
                if (embeddingService == null) {
                    embeddingService = new EmbeddingService(globalCfgMap.get(EmbeddingService.class));
                }
            }
        }
        return embeddingService;
    }

    public AudioService audio() {
        if (audioService == null) {
            synchronized (this) {
                if (audioService == null) {
                    audioService = new AudioService(globalCfgMap.get(AudioService.class));
                }
            }
        }
        return audioService;
    }

    public ModerationService moderation() {
        if (moderationService == null) {
            synchronized (this) {
                if (moderationService == null) {
                    moderationService = new ModerationService(globalCfgMap.get(ModerationService.class));
                }
            }
        }
        return moderationService;
    }

    public ThreadService threads() {
        if (threadService == null) {
            synchronized (this) {
                if (threadService == null) {
                    threadService = new ThreadService(globalCfgMap.get(ThreadService.class));
                }
            }
        }
        return threadService;
    }

    public RunService runs() {
        if (runService == null) {
            synchronized (this) {
                if (runService == null) {
                    runService = new RunService(globalCfgMap.get(RunService.class));
                }
            }
        }
        return runService;
    }

    public BillingService billing() {
        if (billingService == null) {
            synchronized (this) {
                if (billingService == null) {
                    billingService = new BillingService(globalCfgMap.get(BillingService.class));
                }
            }
        }
        return billingService;
    }
}
