package xaos.commands.stockpiles;

import xaos.commands.CommandContext;
import xaos.commands.CommandHandler;
import xaos.stockpiles.Stockpile;

public final class StockpileDisableAllCommandHandler implements CommandHandler {

    @Override
    public void execute(CommandContext context) {
        int pileId = Integer.parseInt(context.getParameter());

        Stockpile.disableAll(
                pileId,
                context.getParameter2()
        );
    }
}