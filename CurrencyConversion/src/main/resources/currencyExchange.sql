USE [tempdb]
GO

/****** Object:  Table [dbo].[currencyExchange]    Script Date: 2/27/2023 10:21:30 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[currency_exchange](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[currency_from] [nvarchar](50) NOT NULL,
	[currency_to] [nvarchar](50) NOT NULL,
	[port] [int] NULL,
	[conversion] [decimal](5, 2) NULL
) ON [PRIMARY]
GO


INSERT INTO dbo.currency_exchange (currency_from, currency_to, port,conversion)
VALUES ('USD','EUR',0,0.94);
INSERT INTO dbo.currencyExchange (currency_from, currency_to, port,conversion)
VALUES ('USD','YEN',0,136.31);