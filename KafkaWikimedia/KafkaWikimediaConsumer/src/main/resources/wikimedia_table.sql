USE [tempdb]
GO

/****** Object:  Table [dbo].[wikimedia_recentchange]    Script Date: 2/28/2023 9:18:14 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[wikimedia_recentchange](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[wiki_event_data] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO